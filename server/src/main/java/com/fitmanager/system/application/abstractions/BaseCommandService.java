package com.fitmanager.system.application.abstractions;

public interface BaseCommandService<T, ID>  {
    <C extends ICommand> ID register(C command); 
    <C extends ICommand> void unregister(C command);
}
