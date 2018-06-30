/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author TRT
 */
// plan out the visitor's route
public interface Visitor{
    // parse headline
    public String visit(HeadlineRegex headlineRegex);
    // parse summary
    public String visit(SummaryRegex summaryRegex);
    // parse date
    public String visit(DateRegex dateRegex);

    //public void visit(DateRegex aThis);
}
 