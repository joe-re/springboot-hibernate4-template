package jp.co.buckets.api.v1;

import java.sql.Date;

import jp.co.buckets.model.OvertimeRequest;
import jp.co.buckets.model.OvertimeRequest.Status;
import jp.co.buckets.service.BookInsertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class OvertimeRequestApi {

    @Autowired
    BookInsertService bookInsertService;
    
    @RequestMapping("/overtime-request")
    @ResponseBody
    public OvertimeRequest home() {
        OvertimeRequest overtimeRequest = new OvertimeRequest();
        overtimeRequest.date = new Date(0);
        overtimeRequest.hour = 1;
        overtimeRequest.status = Status.approval;
        
        bookInsertService.transactionTest();

        return overtimeRequest;
    }

}
