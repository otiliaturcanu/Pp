package org.example
import java.util.Date

class HistoryLogRecorder(val date:Date?,val commandline:String) : Comparable<HistoryLogRecorder> {
    override fun compareTo(other: HistoryLogRecorder): Int {
        val cmp = date?.compareTo(other.date)//1 cea mai recenta data, daca 0 e aceeasi daca e -1 e mai veche
        if (cmp != null) {
            if(cmp>0) return 1
            else if(cmp<0) return -1
            else return 0
        }
        return -1
    }

    override fun toString():String{
        return "$date $commandline"
    }

}