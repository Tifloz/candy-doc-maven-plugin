package io.candydoc.domain;

import io.candydoc.domain.command.ExtractDDDConcepts;
import io.candydoc.domain.events.DomainEvent;
import io.candydoc.domain.exceptions.DocumentationGenerationFailed;
import io.candydoc.domain.exceptions.DomainException;
import io.candydoc.domain.extractor.DDDConceptExtractor;
import java.io.IOException;
import java.util.List;

import io.candydoc.domain.repository.ProcessorUtils;
import lombok.RequiredArgsConstructor;

import javax.tools.Diagnostic;

@RequiredArgsConstructor
public class GenerateDocumentationUseCase {

  private final SaveDocumentationPort saveDocumentationPort;

  public void checkParameters(ExtractDDDConcepts command) throws DocumentationGenerationFailed {
    if (command.getPackagesToScan() == null || command.getPackagesToScan().isEmpty()) {
      throw new DocumentationGenerationFailed(
          "Missing parameters for 'packageToScan'. Check your pom configuration.");
    }
  }

  public void execute(ExtractDDDConcepts command) throws IOException, DomainException {
    DDDConceptExtractor DDDConceptExtractor = new DDDConceptExtractor();
    checkParameters(command);
    List<DomainEvent> domainEvents = DDDConceptExtractor.extract(command);
    saveDocumentationPort.save(domainEvents);
  }
}
