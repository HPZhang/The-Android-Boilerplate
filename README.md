User Request Data flow : ui   -> presentation -> domain       -> data
App Response Data flow : data -> domain       -> presentation -> ui
            
Let ui listen to all events from os or library.

Using android-priority-jobqueue to perform async task in the outermost 
layer, for example: read data from remote server or local.

Using background interactor to do complex business.