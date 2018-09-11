package com.ivan.datatables;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/datatables/documents")
public class DocumentsController {

    private static final Random random = new Random();

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public DatatablesResponse<DocumentsRecord> getDocuments(@RequestParam final String sEcho) {
        final List<DocumentsRecord> documentsRecords = this.generateRecords();
        return new DatatablesResponse<>(documentsRecords.size(), 100_000, sEcho, documentsRecords);
    }

    private List<DocumentsRecord> generateRecords() {
        final ImmutableList.Builder<DocumentsRecord> builder = ImmutableList.builder();

        for (int i = 0; i < 25; i++) {
            builder.add(this.createDocumentsRecord(i));
        }

        return builder.build();
    }

    private LocalDateTime randomDateTime() {
        long minDay = LocalDateTime.of(1970, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
        long maxDay = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDateTime.ofEpochSecond(randomDay, 0, ZoneOffset.UTC);
    }

    private DocumentsRecord createDocumentsRecord(final int id) {
        final DocumentsRecord dr = new DocumentsRecord();

        dr.setCheckBox("<input onchange='enableDisableBulk(this);' id='checkBox_4485163' type='checkbox' name='aCheckBox' value='aValue'/>");
        dr.setTaxonomyNodes(Collections.emptyList());
        dr.setActions("<div class='actionMenu' id='4485163' title='Available actions for this asset'><span class='it_icon icon_downArrowMed'></span><input type='hidden' id='filename4485163' name='filenameAction' value='askAsset-46ed16f5-a8d4-4ae3-bc85-d2455ee63ace.json' /><input type='hidden' id='repositoryId4485163' name='repositoryIdAction' value='912267' /><input type='hidden' id='title4485163' name='titleAction' value='null' /><input type='hidden' id='resourceId4485163' name='resourceIdAction' value='null' /></div><span class='status_icon icon_edit' title='Flagged as Work in Progress by sysadmin'></span>");
        dr.setProductType("KL dert bgt");
        dr.setLegacyId("");
        dr.setContentCreateDate(this.randomDateTime());
        dr.setAuthor("");
        dr.setResourceType(null);
        dr.setInternalAuthor(null);
        dr.setMainEditor("");
        dr.setLawStatedAsDate(this.randomDateTime());
        dr.setDisplayPublishedOnDate(this.randomDateTime());
        dr.setLastReviewedDate(this.randomDateTime());
        dr.setIsMaintained("Yes");
        dr.setImportedFileName(UUID.randomUUID().toString());
        dr.setFileSize(random.nextInt(15000));
        dr.setWordPageCount(random.nextInt(100));
        dr.setSubscriptionRequired("No");
        dr.setCitation(null);
        dr.setMaintenanceDate(this.randomDateTime());
        dr.setResourceId(null);
        dr.setFilename(UUID.randomUUID().toString());
        dr.setTitle(null);
        dr.setCheckinDate(this.randomDateTime());
        dr.setPublishDate(this.randomDateTime());
        dr.setInitialPublishDate(this.randomDateTime());
        dr.setTags("<span title=''></span>");
        dr.setImportDate(this.randomDateTime());
        dr.setImportedBy("<span title='sysadmin'>sysadmin</span>");
        dr.setUuid(null);
        dr.setConvertRequestId(null);
        dr.setAcrId(String.valueOf(random.nextInt(1_000_000)));
        dr.setId(id);
        dr.setDT_RowId("rowid_" + random.nextInt(9_999_999));
        dr.setOnNovus("No");
        dr.setStatus("<div class='doc-statuses'><span><div class='CONVERT_NOT_RUN' id='convert_status_4485163' title='Not Converted'></div></span><span><div class='PUBLISH_NOT_RUN' id='publish_status_4485163' title='Never Published'></div></span><span><div class='OFF_NOVUS' id='on_novus_4485163' title='Not On Novus'></div></span><span><div class='publish_needed' id='publish_needed_4485163' title='Unpublished Content Changes'></div></span></div><div class='doc-statuses'><span> </span></div>");

        return dr;
    }
}
