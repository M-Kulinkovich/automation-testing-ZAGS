package org.example.models.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationStatusResult {
    private Integer applicantid;
    private String dateofapplication;
    private String kindofapplication;
    private String channel;
    private String statusofapplication;
}
