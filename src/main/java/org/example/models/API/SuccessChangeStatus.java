package org.example.models.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessChangeStatus {
    private Integer applicantid;
    private Integer applicationid;
    private Integer citizenid;
    private String dateofapplication;
    private String kindofapplication;
    private String statusofapplication;
    private Integer staffid;
    private String channel;
    private Object image;
}

