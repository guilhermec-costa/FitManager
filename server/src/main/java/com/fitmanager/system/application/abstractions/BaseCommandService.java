package com.fitmanager.system.application.abstractions;

public interface BaseCommandService<T>  {
    <C extends ICommand > void register(C command); 
}
