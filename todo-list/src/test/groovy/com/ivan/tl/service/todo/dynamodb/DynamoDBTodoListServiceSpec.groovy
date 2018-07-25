import com.google.common.collect.ImmutableList
import com.ivan.tl.service.todo.dynamodb.DynamoDBTodoListService
import com.ivan.tl.service.todo.dynamodb.entity.TodoItemEntity
import com.ivan.tl.service.todo.dynamodb.repository.EntityIdGeneratorRepository
import com.ivan.tl.service.todo.dynamodb.repository.TodoItemRepository

public class DynamoDBTodoListServiceSpec extends spock.lang.Specification {

    private TodoItemRepository todoItemRepository;
    private EntityIdGeneratorRepository entityIdGeneratorRepository;

    private DynamoDBTodoListService service;

    def setup() {
        todoItemRepository = Stub(TodoItemRepository.class);
        entityIdGeneratorRepository = Stub(EntityIdGeneratorRepository.class);
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

}