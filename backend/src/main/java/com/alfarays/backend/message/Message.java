package com.alfarays.backend.message;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_sequence_generator")
    @SequenceGenerator(name="message_id_sequence_generator", sequenceName = "message_id_sequence", initialValue = 1, allocationSize = 50)
    private Long id;

    private String content;
    private String timestamp;
    private String sender;
    private String receiver;

}
