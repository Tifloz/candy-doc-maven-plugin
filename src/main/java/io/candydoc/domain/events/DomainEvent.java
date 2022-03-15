package io.candydoc.domain.events;

public interface DomainEvent {

  void accept(Visitor visitor);

  interface Visitor {
    void apply(BoundedContextFound event);

    void apply(CoreConceptFound event);

    void apply(InteractionBetweenConceptFound event);

    void apply(ValueObjectFound event);

    void apply(DomainEventFound event);

    void apply(DomainCommandFound event);

    void apply(AggregateFound event);

    void apply(NameConflictBetweenCoreConcepts event);

    void apply(ConceptRuleViolated event);
  }
}
