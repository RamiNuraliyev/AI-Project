(define (domain unblockMe-World)
    (:requirements 
        :typing
    )

    (:types
       Brick  
       location 
    )

    (:predicates
       (at ?B -Brick ?l -location)
       (isV ?b -Brick)
       (isH ?b -Brick)
       (empty ?l -location)
       (big ?b -Brick)
       (small ?b -Brick)
       (leftTo ?l1 -location ?l2 -location)
       (rightTo ?l1 -location ?l2 -location)
       (upTo ?l1 -location ?l2 -location)
       (downTo ?l1 -location ?l2 -location)
    )
    
     (:action movLeftSmall
        :parameters (?b -Brick ?l1 -location ?l2 -location ?dest -location)
        :precondition (and (isH ?b) (small ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (leftTo ?dest ?l1) (leftTo ?l1 ?l2))
        :effect (and (empty ?l2) (at ?b ?dest) (not (at ?b ?l2) ) (not (empty ?dest)))
    )
    
    (:action movRightSmall
        :parameters (?b -Brick ?l1 -location ?l2 -location ?dest -location)
        :precondition (and (isH ?b) (small ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (rightTo ?dest ?l2) (rightTo ?l2 ?l1))
        :effect (and (empty ?l1) (at ?b ?dest) (not (at ?b ?l1)) (not (empty ?dest)))
    )
    
    (:action movLeftBig
        :parameters (?b -Brick ?l1 -location ?l2 -location ?l3 -location ?dest -location)
        :precondition (and (isH ?b) (big ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (at ?b ?l3) (leftTo ?dest ?l1) (leftTo ?l1 ?l2) (leftTo ?l2 ?l3))
        :effect (and (empty ?l3) (at ?b ?dest) (not (at ?b ?l3)) (not (empty ?dest)))
    )
    
    (:action movRightBig
        :parameters (?b -Brick ?l1 -location ?l2 -location ?l3 -location ?dest -location)
        :precondition (and (isH ?b) (big ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (at ?b ?l3) (rightTo ?dest ?l3) (rightTo ?l3 ?l2) (rightTo ?l2 ?l1))
        :effect (and (empty ?l1) (at ?b ?dest) (not (at ?b ?l1) ) (not (empty ?dest)))
    )
    
    (:action movUpsmall
    :parameters(?b -Brick ?l1 -location ?l2 -location ?dest -location)
    :precondition (and (isV ?b) (small ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (upTo ?dest ?l1) (upTo ?l1 ?l2))
    :effect (and (empty ?l2) (at ?b ?dest) (not (empty ?dest)) (not (at ?b ?l2)))
    )
    
    (:action movDownsmall
    :parameters(?b -Brick ?l1 -location ?l2 -location ?dest -location)
    :precondition(and (isV ?b) (small ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (downTo ?dest ?l2) (downTo ?l2 ?l1))
    :effect (and (empty ?l1) (at ?b ?dest)(not (empty ?dest))(not (at ?b ?l1)) )
    )
    
    (:action movUpBig
    :parameters(?b -Brick ?l1 -location ?l2 -location ?l3 -location ?dest -location)
    :precondition(and (isV ?b) (small ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (at ?b ?l3) (upTo ?dest ?l1) (upTo ?l1 ?l2) (upTo ?l2 ?l3))
    :effect (and (empty ?l3) (at ?b ?dest)(not (empty ?dest))(not (at ?b ?l3)) )
    )
    
    (:action movDownBig
    :parameters(?b -Brick ?l1 -location ?l2 -location ?l3 -location ?dest -location)
    :precondition(and (isV ?b) (big ?b) (empty ?dest) (at ?b ?l1) (at ?b ?l2) (at ?b ?l3) (downTo ?dest ?l3) (downTo ?l3 ?l2) (downTo ?l2 ?l1))
    :effect (and (empty ?l1) (at ?b ?dest) (not (empty ?dest)) (not (at ?b ?l1)) )
    )
    
    
)