# Implementation Notes
This file keeps track of implementation notes that don't necessarily fit in a comment for a single file.
This is loosely inspired by [architecture decision records](https://martinfowler.com/bliki/ArchitectureDecisionRecord.html), but each record is a heading.

## Each class is in its own source file
I _could_ stack classes into a single file, but that would be gross.

## ArrayList, not Vector
The requirements document states that either ArrayList or Vectors could be extended.
I did some research and it looks like consensus is that ArrayLists should be used whenever possible instead of Vectors.

From [Core Java, Vol. I: Fundamentals, 14th Edition](https://learning.oreilly.com/library/view/core-java-vol/9780135558553/):
> In even older versions of Java, programmers used the Vector class for dynamic arrays. However, the ArrayList class is more efficient, and there is no longer any good reason to use the Vector class.

From [this StackOverflow post](https://learning.oreilly.com/library/view/core-java-vol/9780135558553/):
> Vector synchronizes on each individual operation. That's almost never what you want to do.

The tl;dr is: just use arraylist.

## Simple input-based UI
It'd be cool to use a UI framework like [Tambo](https://tamboui.dev), but let's keep it easy.
Just use Scanner and IO.

## Interfaces will go in <_>ADT.java
The textbook calls stacks and queues abstract data types.
The interfaces define the methods associated with the abstract data types.
