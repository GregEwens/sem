# USE CASE: <number> <the name should be the goal as a short active verb phrase>

## CHARACTERISTIC INFORMATION

### Goal in Context

As *a member of the organisation* I want to *produce a country report showing all countries in a region ordered by population (largest first)* so that *I may support the organisation with accurate data*.

### Scope

Company

### Level

Primary task

### Preconditions

The Database contains all of the current population data of the countries in the region, the region the data is required for should be defined.

### Success End Condition

A report is available for the member of the organisation to view and support the organisation with.

### Failed End Condition

No report or inaccurate report is produced.

### Primary Actor

The user of the system.

### Trigger

The organisation requires information that the user of the system supplies.

## MAIN SUCCESS SCENARIO

1. A member of the organisation requests data on country in a defined region ordered by population high to low..
2. The user of the system takes note of who the member of the organisation is.
3. The user of the system extracts the population data of countries in the defined region, ordered high to low.
4. The user of the system supplies this report to the member of the organisation.

## EXTENSIONS

region does not exist or is incorrectly entered into the system.

1. The user of the system informs the member of the organisation that the defined region does not exist or is incorrect.

## SUB-VARIATIONS

none

## SCHEDULE

**DUE DATE**: Sprint 1