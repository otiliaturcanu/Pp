package org.example

class SyslogRecord(val stamp:String,val hostname:String,val aplication:String,val pid:Int?, val entry:String) {

    override fun toString():String{
        return "$stamp $hostname $aplication $pid $entry"
    }

}