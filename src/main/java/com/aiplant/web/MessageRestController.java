package com.aiplant.web;

import com.aiplant.domain.Message;
import com.aiplant.domain.MessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/msg")
public class MessageRestController {

    private MessageRepository repository;

    @Inject
    public void setRepository(MessageRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addMessage(@RequestBody Message Message) {
        return new ResponseEntity<>(repository.save(Message), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Message>> getAllMessages() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Message> getMessageWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Message>> findMessageWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByGroupName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Message> updateMessageFromDB(@PathVariable("id") long id, @RequestBody Message Message) {

        Message currentMessage = repository.findOne(id);
        currentMessage.setType(Message.getType());
        currentMessage.setText(Message.getText());
        currentMessage.setGroupName(Message.getGroupName());

        return new ResponseEntity<>(repository.save(currentMessage), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteMessageWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllMessages() {
        repository.deleteAll();
    }
}
