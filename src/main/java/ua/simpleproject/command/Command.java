package ua.simpleproject.command;

import ua.simpleproject.exception.DAOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, DAOException;
}
