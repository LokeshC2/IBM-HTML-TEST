package org.ibm.studentstreamservice.controller;

import org.ibm.studentstreamservice.model.Stream;
import org.ibm.studentstreamservice.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streams")
public class StreamController {

    @Autowired
    Environment environment;

    @Autowired
    StreamService streamService;

    @GetMapping
    public ResponseEntity<Iterable<Stream>> getStreams() {
        return ResponseEntity.ok(streamService.getStreams());
    }
    
    @GetMapping("/status")
    public ResponseEntity<String> getStream() {
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        return ResponseEntity.ok("Stream Server is up and running on port " + port + ".");
    }

    @PostMapping
    public ResponseEntity<Stream> createStream(@RequestBody Stream stream) {
        return ResponseEntity.ok(streamService.createStream(stream));
    }

}
