package dev.orhidea.edenlib.database;

import dev.orhidea.edenlib.util.Callback;

import java.util.List;

public interface ILogDatabase<Target, Log> {

    void addLog(Target target, Log log);

    void getLog(Target target, long timeMs, Callback<Log> callback);

    void getLogs(Target target, Callback<List<Log>> callback);

    void shrinkLogs(Target target, List<Log> logs);

    void deleteLog(Target target, long timeMs);

    void setupTable(Target target);

}
