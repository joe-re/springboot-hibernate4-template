package jp.co.buckets.model;

import java.sql.Date;

public class OvertimeRequest {
    public enum Status {pending, approval, reject};

    public Date date;
    public float hour;
    public Status status;
}
