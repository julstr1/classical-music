package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Composer;
import com.example.classicalmusic.service.ComposerService;
import com.nimbusds.jwt.JWT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/composers")
@Tag(name = "Composers Controller", description = "This REST controller provide services to manage composers in the classical-music application.")
public class ComposerController {
    ComposerService composerService;

    @Autowired
    public ComposerController(ComposerService composerService) {
        this.composerService = composerService;
    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all composers available in the classical-music application.")
    public Iterable<Composer> getAllComposers(@AuthenticationPrincipal Jwt jwt) {
        return  composerService.getComposers();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides composers details for the supplied composer id from the classical-music application.")
    public  Composer getComposerById(@PathVariable("id") long composerId, @AuthenticationPrincipal Jwt jwt) {
        return composerService.getComposerById(composerId);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Creates a new composer in the classical-music application")
    public Composer createComposer(@Valid @RequestBody Composer composer, @AuthenticationPrincipal Jwt jwt) {
        return composerService.createComposer(composer);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the composer details in the classical-music application for the supplied composer id.")
    public Composer updateComposer(@Valid @RequestBody Composer composer, @PathVariable long id, @AuthenticationPrincipal Jwt jwt) {
        return composerService.updateComposer(composer, id);
    }


    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the composer details in the classical-music application for the supplied composer id.")
    public void updateExistingComposer(@Valid @RequestBody Map<String, Object> updates, @PathVariable long id, @AuthenticationPrincipal Jwt jwt) {
        Composer composer = composerService.getComposerById(id);
        updates.forEach(
                (update,value) -> {
                    switch (update) {
                        case "name":
                            composer.setName((String) value);
                            break;
                        case "completeName":
                            composer.setCompleteName((String) value);
                            break;
                        case "birth":
                            composer.setBirth((String) value);
                            break;
                        case "death":
                            composer.setDeath((String) value);
                            break;
                        case "epoch":
                            composer.setEpoch((String) value);
                            break;
                    }
                }
        );
        composerService.updateComposer(composer, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletes the composer details for the supplied composer id from the classical-music application.")
    public void deleteComposerById(@PathVariable("id") long composerId, @AuthenticationPrincipal Jwt jwt) {
        composerService.deleteById(composerId);
    }


}
