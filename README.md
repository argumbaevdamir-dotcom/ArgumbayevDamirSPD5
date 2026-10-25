# Assignment SDP5 — Strategy Pattern

**Student:** Argumbayev Damir  
**Course:** Software Design Patterns  
**Project:** Macaron Shop

## Idea

This project continues the Macaron Shop domain from SDP4. A customer can order macarons prepared with different recipe algorithms: classic, vegan, or premium. The client chooses a recipe strategy at runtime. `MacaronOrderService` delegates preparation to the selected strategy and contains no `if` or `switch` statements for recipe types.

## Pattern participants

| Role | Class |
|---|---|
| Strategy interface | `MacaronPreparationStrategy` |
| Concrete strategies | `ClassicMacaronStrategy`, `VeganMacaronStrategy`, `PremiumMacaronStrategy` |
| Context | `MacaronOrderService` |
| Client | `MacaronShopApplication` |

## Runtime switching

`MacaronShopApplication` creates one service, prepares the same order with the classic recipe, then switches the service to vegan and premium recipes. The context remains unchanged while the preparation algorithm changes.

## Clean Code decisions

1. **Polymorphism instead of branching:** `MacaronOrderService` delegates to `MacaronPreparationStrategy`; it does not select a recipe with conditional statements.
2. **Meaningful names:** names such as `PremiumMacaronStrategy`, `MacaronOrder`, and `PreparationResult` clearly state their purpose.
3. **Single Responsibility:** each strategy implements one recipe algorithm; the context only stores and delegates to a strategy.
4. **Algorithm-agnostic context:** the context depends on the strategy interface, not on recipe details.
5. **Easy extensibility:** a new recipe is added by implementing `MacaronPreparationStrategy`, without changing the service.
6. **Validation at the boundary:** `MacaronOrder` rejects invalid quantity and blank flavour values on creation.
7. **Immutability:** `MacaronOrder` and `PreparationResult` cannot be changed after they are created.

## Compile and run

From the project root:

```bash
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
java -cp out kz.damir.macaron.MacaronShopApplication
```

## What to explain at the defense

- The client chooses a recipe strategy and can replace it at runtime.
- The context knows only the `MacaronPreparationStrategy` interface.
- Each concrete strategy encapsulates one independent preparation algorithm.
- Adding a new recipe, for example `SugarFreeMacaronStrategy`, follows the Open/Closed Principle: add a class without changing the service.
