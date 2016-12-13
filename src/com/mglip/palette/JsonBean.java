package com.mglip.palette;

import java.util.List;

/**
 * @author shianqi@imudges.com
 *         Created by shianqi on 2016/12/4
 */
public class JsonBean {
    public static class Results{
        public String _id;
        public String word;
        public String wordIndex;
        public String str;
        public String createAtDate;
        public String updateAtDate;
        public String ipAddress;
        public String phoneId;
        public String __v;



    }

    public List<Results> results;
}
