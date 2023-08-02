package org.ibm.studentstreamservice.service;

import org.ibm.studentstreamservice.model.Stream;
import org.ibm.studentstreamservice.repo.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    StreamRepository streamRepository;

    @Override
    public Stream createStream(Stream stream) {
        return streamRepository.save(stream);
    }

    @Override
    public Iterable<Stream> getStreams() {
        return streamRepository.findAll();
    }
    
}
