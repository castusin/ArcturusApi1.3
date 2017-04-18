package com.cis;
public class call
    {
    public static void main(String[] args) throws Exception
        {
        send_sms smsObj = new send_sms();
        smsObj.setparams("http://api-global.solutionsinfini.com/v3/","method","1ixxxxxxxxxxxxxx","BUxxxx");
        smsObj.send_sms("99xxxxxxxx", "message", "http://www.yourdomainname.domain/yourdlrpage&custom=XX");
        smsObj.schedule_sms("99xxxxxxxx", "message", "http://www.yourdomainname.domain/yourdlrpage&custom=XX", 
                            "YYYY-MM-DD HH:MM:SS");
        smsObj.unicode_sms("99xxxxxxxx", "message", "http://www.yourdomainname.domain/yourdlrpage&custom=XX","1");
        smsObj.messagedelivery_status("1xxx-x");
        smsObj.groupdelivery_status("1xxx");
        //smsObj.setsender_id("txxxxx");
        //smsObj.setworking_key("1ixxxxxxxxxxxxxx");
        //smsObj.setapi_url("URL");
        }
    }