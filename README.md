layers from outside to inside:
    ui -> presentation -> storage(repository -> data) -> domain

User Request Data flow :
    ui -> presentation -> domain -> storage
    ui -> presentation           -> storage
    
App Response Data flow : 
    storage -> domain -> presentation -> ui
    storage           -> presentation -> ui
            
Let ui listen to all events from os or library.

Using android-priority-jobqueue to perform async task, for example: read data from remote server or local.

Using background interactor to do complex business.