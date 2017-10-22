# ReROUTE
Welcome to ReROUTE! This is a software used to model & simulate real-life metro, subway, and train systems, with an optimized signal system as well as dynamic traffic control. The system is modeled on real life communications based train control systems (an example fron the New York Subway: https://www.youtube.com/watch?v=Mjx3S3UjmnA) and inspired by the ongoing upgrade of the Toronto Transit Commissions Line 1 Signal Upgrades (here: https://www.youtube.com/watch?v=yJlsSQBhKgE). Our first route to be modeled will as such be TTC Line 1.

"ReROUTING" to an autonomous future.

This is a project intended for THacks 2.

# What it does
ReROUTE is an open source automated train system. Its purpose is to communicate and manage trains to avoid dangerous encounters, while also reaching destinations and moving passengers in the most efficient manner possible. ReROUTE ensures that passengers arrive at their station swiftly and safely, guaranteeing an on-time arrival. 

# How it works
Utlilzing classes for passenger, train, station, terminus, route, and depot, all aspects of a train system send information to each other about current situations. They cooridnate variables to perform the duties of a subway operator, but with a higher degree of accuracy and precision. A graphical user interface depicts the general behaviour of the Toronto subway system with this autonomous software integrated. 

# Development Plan
Features we intend to add:

-Real Time Variable Traffic
 ~An RTC (Real Time Clock) feature simulates peak periods

-Realistic Location Variable Traffic
 ~Different stations feature varying levels of traffic to match real-life counterparts

-Intelligent Train Dispatch
 ~More trains can be brought online to manage demand

-Intelligent Train Spacing 
 ~Train spacing can be dependent on speed, desired headway, and track conditions

-Dynamic Speed Control
 ~Train spacing and speed are interconnected

# Acknowledgements

We would like to thank THacks, the Toronto Hacker Club, and the University of Toronto for thisopportunity for us to learn and grow through developing this project.
