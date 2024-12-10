package org.example.models.API;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeStatusRequest {
    private Integer applId;
    private Integer staffid;
    private String action;
}
