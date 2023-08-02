package org.ibm.studentstreamservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stream {
    
    private String streamName;
    private String streamHead;

}
