## why do we want to terminate thread?
- consuming resources
  - memory and cpu


## when do we want to terminate it?
- when it finishes, the application is still running, we need to clean it up
- the thread is misbehaving, we need to get rid of it

## when can we interrupt a thread
1. if the thread is executing a method that throws an interruptException.
2. if the thread's code is handling the interrupt signal explicitly

## Daemon thread
Background threads that do not prevent the threads from exiting when if the main thread terminates

### scenario 1
background task, should not block our application from terminating

for example: File saving thread in a Text Editor

### scenario 2
code in a worker thread not under our control, we do not want it to block our application from terminating

for example: worker thread that uses external library.

