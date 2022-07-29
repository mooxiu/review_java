# performance criteria

- Latency (time)
- Throughtput (tasks completed in unit time)

## Latency
theoretically reduction of latency by t/n

- what is n?
  - how many subtasks: number of cores, so they are parallel
- does break and aggregate for free? 
  - breaking task into small segment
  - thread creation, passing task to thread
  - time between thread.start() to thread get scheduled
  - time until the last thread finishes and signal
  - time until aggregating thread run
  - aggregating
- can we break task into subtasks?
  - not always

## Throughput
### Thread pool