package com.alfarays.backend.message;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageResource {

    private final MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity<Message> message(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                messageService.getMessageById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<Message>> allMessages(){
        return ResponseEntity.ok(
                messageService.getAllMessages()
        );
    }

    @PostMapping
    public ResponseEntity<Message> create(
            @RequestBody Message message
    ){
        return ResponseEntity.ok(
                messageService.createMessage(message)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(
            @PathVariable Long id,
            @RequestBody Message updatedMessage
    ){
        return ResponseEntity.ok(
                messageService.updateMessage(id, updatedMessage)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

}
