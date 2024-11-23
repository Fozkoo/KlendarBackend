package com.example.ccalendarbackend.Repository;

import com.example.ccalendarbackend.Models.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    // Query para eliminar los attachments que no están relacionados con ningún evento
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM attachments\n" +
            "WHERE NOT EXISTS (\n" +
            "    SELECT 1\n" +
            "    FROM event_has_attachments eh\n" +
            "    WHERE eh.attachments_idattachments = attachments.idattachments\n" +
            ");", nativeQuery = true)
    void deleteOrphanAttachments();

}
