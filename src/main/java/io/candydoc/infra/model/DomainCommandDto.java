package io.candydoc.infra.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@Getter
@EqualsAndHashCode(callSuper = true)
public class DomainCommandDto extends ConceptDto {
}
