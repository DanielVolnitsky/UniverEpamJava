//package tasks.task9_05_12_2017.beesAndPuch.entities;
//
//import java.util.Queue;
//
//public class ForestSegments {
//    private Queue<ForestSegment> segmentsQueue;
//
//    {
//      segmentsQueue = new
//    }
//
//    public ForestSegments() {
//
//    }
//
//    public Queue<ForestSegment> getSegmentsQueue() {
//        return segmentsQueue;
//    }
//
//    public void setSegmentsQueue(Queue<ForestSegment> segmentsQueue) {
//        this.segmentsQueue = segmentsQueue;
//    }
//
//    public synchronized ForestSegment getNextSegment() throws Exception {
//        if (!segmentsQueue.isEmpty()) {
//            return segmentsQueue.poll();
//        }
//        throw new Exception("queue is empty");
//    }
//}
