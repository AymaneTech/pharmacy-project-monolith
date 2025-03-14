CREATE TABLE event_publication
(
    id               UUID         NOT NULL,
    listener_id      VARCHAR(255) NOT NULL,
    event_type       VARCHAR(255) NOT NULL,
    serialized_event TEXT         NOT NULL,
    publication_date TIMESTAMP    NOT NULL,
    completion_date  TIMESTAMP,
    PRIMARY KEY (id, listener_id)
);