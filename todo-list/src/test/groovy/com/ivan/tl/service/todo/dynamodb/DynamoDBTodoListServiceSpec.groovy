import com.google.common.collect.ImmutableList
import com.ivan.tl.model.TodoItem
import com.ivan.tl.model.TodoItemId
import com.ivan.tl.model.TodoItemStatus
import com.ivan.tl.service.todo.dynamodb.DynamoDBTodoListService
import com.ivan.tl.service.todo.dynamodb.entity.TodoItemEntity
import com.ivan.tl.service.todo.dynamodb.repository.EntityIdGeneratorRepository
import com.ivan.tl.service.todo.dynamodb.repository.TodoItemRepository
import spock.lang.Specification
import spock.lang.Unroll

public class DynamoDBTodoListServiceSpec extends Specification {

    private TodoItemRepository todoItemRepository;
    private EntityIdGeneratorRepository entityIdGeneratorRepository;

    private DynamoDBTodoListService service;

    def setup() {
        todoItemRepository = Mock(TodoItemRepository.class);
        entityIdGeneratorRepository = Mock(EntityIdGeneratorRepository.class);
        service = new DynamoDBTodoListService(todoItemRepository, entityIdGeneratorRepository);
    }

    def "getAllItems returns all existing items"() {
        given:
        def entity = new TodoItemEntity(1, "Create", "Description", false);
        todoItemRepository.findAll() >> ImmutableList.of(entity);

        when:
        def result = service.getAllItems();

        then:
        result.size() == 1;
        def item = result.get(0);
        item.getId() == entity.getId();
        item.getName() == entity.getName();
        item.getDescription() == entity.getDescription();
    }

    def "getAllItems when there are no items returns empty list"() {
        given:
        todoItemRepository.findAll() >> Collections.emptyList();

        when:
        def result = service.getAllItems();

        then:
        result != null;
        result.size() == 0;
    }

    def "createItem creates item and returns item id"() {
        given:
        entityIdGeneratorRepository.incrementCounter(TodoItemEntity.TABLE_NAME) >> 4;

        def newItem = new TodoItem("Test", "Test description");

        when:
        def itemId = service.createItem(newItem);

        then:
        itemId != null;
        itemId.getId() == 4;

        1 * todoItemRepository.save({ item ->
            item.getId() == 5;
            item.getName() == newItem.getName();
            item.getDescription() == newItem.getDescription();
            item.isDone() == false;
        })
    }

    @Unroll
    def "toggleStatus negates the previous status #param"() {
        given:
        def itemId = new TodoItemId(15L)
        todoItemRepository.findById(itemId.getId()) >> Optional.of(new TodoItemEntity(itemId.getId(), "Name", "Descr", param))

        when:
        service.updateStatus(itemId, new TodoItemStatus(!param))

        then:
        1 * todoItemRepository.save({ entity ->
            entity.isDone() == expected
        })

        where:
        param | expected
        true  | false
        false | true
    }

}