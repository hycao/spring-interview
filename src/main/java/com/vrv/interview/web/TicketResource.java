package com.vrv.interview.web;

import com.vrv.interview.domain.Ticket;
import com.vrv.interview.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 门票资源接口
 *
 * @author hycao
 */
@Slf4j
@RestController
public class TicketResource {

    private final TicketService ticketService;

    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTicket(@PathVariable String id) {
        Optional<Ticket> ticket = ticketService.lambdaQuery().eq(Ticket::getId, id).oneOpt();
        if (!ticket.isPresent()) {
            log.info("Ticket not found, id={}", id);
            return ResponseEntity.ok(ResponseEntity.noContent());
        }
        return ResponseEntity.ok(ticket.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeTicket(@PathVariable Long id) {
        ticketService.removeById(id);
        return ResponseEntity.ok(ResponseEntity.accepted());
    }

    @PostMapping()
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
        return ResponseEntity.ok(ticket);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable String id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        ticketService.updateById(ticket);
        return ResponseEntity.ok(ticket);
    }
}
