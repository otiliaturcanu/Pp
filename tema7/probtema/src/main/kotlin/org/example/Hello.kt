package org.example

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

fun getMostRecent(a : HistoryLogRecorder, b : HistoryLogRecorder) : HistoryLogRecorder{
    var c = a.compareTo(b)
    if(c == 1) return a
    else return b
}


fun main(args: Array<String>) {

    lateinit var date : Date
    var recorder = mutableListOf<HistoryLogRecorder>()
    var map : HashMap<Date?, HistoryLogRecorder> = mutableMapOf<Date?, HistoryLogRecorder>() as HashMap<Date?, HistoryLogRecorder>//hashmap mai rapidvaloare cheie

    File("history.log").forEachLine {
        //println(it)
        if(it.contains("Start-Date:")){
            var a = it.split("Start-Date: ")//a  are 2 elem Start-Date: si 2022-04-14  19:12:15 ca sa separe linia asta split
            var b = a[1].split(" ")//b[1] e spatiul
            var day = b[0]
            var time = b[2]
            var dayandtime = day + " " + time
            date = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dayandtime)//parse transforma  SimpledateFormat=timestamp
        }
        if(it.contains("Commandline:")){
            var a = it.split("Commandline: ")
            var rec = HistoryLogRecorder(date, a[1])//a[1] = /usr/bin/unattended-upgrade
            recorder.add(rec)
        }
    }

    recorder.asSequence()
        .forEach {
            map.put(it.date, it)//cheie-valoare /pune data si  data+ commandline data ob curent si obiectul
        }
    println(map)

    println(getMostRecent(recorder[0], recorder[1]))

}