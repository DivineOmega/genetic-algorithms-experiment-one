# Genetic Algorithms Experiment One

This repository is a experimentation in evolving ASCII creatures using genetic algoritms.

When running this application, you must first define a 5x5 ASCII creature (or anything really), such as the following.

```
\____/
/    |
|  o:<
\____|
/    \
```

This creature is considered the ideal specimen. The genetic algorithm then evolves generation after generation of creatures, starting with a random population. Each new generation's population is made by breeding together (and mutating) creatures from the previous generation. The parent creatures are selected randomely, with a higher chance of selection going to creatures that are more similar to the ideal specimen previously specified.
