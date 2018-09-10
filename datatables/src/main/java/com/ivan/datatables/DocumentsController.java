package com.ivan.datatables;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/datatables/documents")
public class DocumentsController {

    @GetMapping
    public DatatablesResponse<DocumentsRecord> getDocuments(@RequestParam final String sEcho) {
        final List<DocumentsRecord> documentsRecords = this.generateRecords();
        return new DatatablesResponse<>(documentsRecords.size(), documentsRecords.size(), sEcho, documentsRecords);
    }

    private List<DocumentsRecord> generateRecords() {
        return ImmutableList.<DocumentsRecord>builder()
                .add(new DocumentsRecord(1, "Report1", "Taxes report", "Accountant", 13456, this.randomDateTime()))
                .add(new DocumentsRecord(2, "Report2", "Expenses report", "Chief accountant", 1422, this.randomDateTime()))
                .add(new DocumentsRecord(3, "Report3", "Rings report", "Gandalf Gray", 120508, this.randomDateTime()))
                .add(new DocumentsRecord(4, "Report4", "Dummy report", "Dummy", 111, this.randomDateTime()))
                .build();
    }

    private LocalDateTime randomDateTime() {
        long minDay = LocalDateTime.of(1970, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
        long maxDay = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDateTime.ofEpochSecond(randomDay, 0, ZoneOffset.UTC);
    }

}
