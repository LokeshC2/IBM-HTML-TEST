package org.ibm.studentstreamservice.service;

import org.ibm.studentstreamservice.model.Stream;

public interface StreamService {

    Stream createStream(Stream stream);

    Iterable<Stream> getStreams();
    
}
