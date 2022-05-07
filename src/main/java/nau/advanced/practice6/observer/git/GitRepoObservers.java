package nau.advanced.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;

public class GitRepoObservers {
    public static Repository newRepository() {
        return new Repository() {
            ArrayList<WebHook> webHooks = new ArrayList<>();
            ArrayList<Event> eventList = new ArrayList<>();

            @Override
            public void addWebHook(WebHook webHook) {
                webHooks.add(webHook);
            }

            @Override
            public Commit commit(String branch, String author, String[] changes) {
                Commit commit = new Commit(author, changes);
                ArrayList<Commit> commits = new ArrayList<>();
                commits.add(commit);

                Event event = new Event(Event.Type.COMMIT, branch, commits);
                boolean added = false;
                for (WebHook hook : webHooks) {
                    if (hook.type() == event.type() && hook.branch().equals(event.branch())) {
                        hook.onEvent(event);
                        if (!added) {
                            added = true;
                            eventList.add(event);
                        }
                    }
                }
                return commit;
            }

            @Override
            public void merge(String sourceBranch, String targetBranch) {
                ArrayList<Event> events = new ArrayList<>();
                for (Event event : eventList) {
                    if (event.branch().equals(sourceBranch)) {
                        events.add(event);
                    }
                }

                ArrayList<Commit> commits = new ArrayList<>();
                for (Event event : events) {
                    commits.addAll(event.commits());
                    eventList.remove(event);
                }

                Event event = new Event(Event.Type.MERGE, targetBranch, commits);
                eventList.add(event);
                for (WebHook hook : webHooks) {
                    if (hook.type() == event.type() && hook.branch().equals(event.branch())) {
                        hook.onEvent(event);
                    }
                }
            }
        };
    }

    public static WebHook mergeToBranchWebHook(String branchName) {
        ArrayList<Event> events = new ArrayList<>();
        return new WebHook() {
            @Override
            public String branch() {
                return branchName;
            }

            @Override
            public Event.Type type() {
                return Event.Type.MERGE;
            }

            @Override
            public List<Event> caughtEvents() {
                return events;
            }

            @Override
            public void onEvent(Event event) {
                events.add(event);
            }
        };
    }

    public static WebHook commitToBranchWebHook(String branchName) {
        ArrayList<Event> events = new ArrayList<>();
        return new WebHook() {
            @Override
            public String branch() {
                return branchName;
            }

            @Override
            public Event.Type type() {
                return Event.Type.MERGE;
            }

            @Override
            public List<Event> caughtEvents() {
                return events;
            }

            @Override
            public void onEvent(Event event) {
                events.add(event);
            }
        };
    }
}