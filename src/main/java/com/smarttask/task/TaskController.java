package com.smarttask.task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/tasks")
public class TaskController {
 private final TaskRepository repo;
 public TaskController(TaskRepository repo){this.repo=repo;}
 @GetMapping public List<Task> all(){return repo.findAll();}
 @GetMapping("/{id}") public Task one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not found"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Task create(@Valid @RequestBody Task t){t.setId(null); normalize(t); return repo.save(t);}
 @PutMapping("/{id}") public Task update(@PathVariable Long id,@Valid @RequestBody Task in){Task t=one(id);t.setTitle(in.getTitle());t.setDescription(in.getDescription());t.setPriority(in.getPriority());t.setDueDate(in.getDueDate());t.setCompleted(in.isCompleted());normalize(t);return repo.save(t);}
 @PatchMapping("/{id}/toggle") public Task toggle(@PathVariable Long id){Task t=one(id);t.setCompleted(!t.isCompleted());return repo.save(t);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND);repo.deleteById(id);}
 private void normalize(Task t){if(t.getPriority()==null||!List.of("LOW","MEDIUM","HIGH").contains(t.getPriority().toUpperCase()))t.setPriority("MEDIUM");else t.setPriority(t.getPriority().toUpperCase());}
}