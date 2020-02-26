package br.com.push.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.push.service.PushService;

@RestController
public class PushResource {

    @Autowired
    private PushService pushService;

    @PostMapping(value = "/sendPush")
    public ResponseEntity<Void> sendPush() {
        pushService.push();
        return ResponseEntity.noContent().build();
    }
}
