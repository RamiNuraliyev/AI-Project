(define (problem easy)
(:domain unblockMe-World)
(:objects brick1 -brick brick2 -brick brick3 -brick brick4 -brick brick5 -brick brick6 -brick brick7 -brick brick8 -brick brick9 -brick brick10 -brick brick11 -brick  red -brick
          l11 -location l12 -location l13 -location l14 -location l15 -location l16 -location l21 -location l22 -location l23 -location l24 -location l25 -location l26 -location l31 -location l32 -location l33 -location -location l34 -location l35 -location l36 -location l41 -location l42 -location l43 -location l44 -location l45 -location l46 -location l51 -location l52 -location l53 -location l54 -location l55 -location l56 -location l61 -location l62 -location l63 -location l64 -location l65 -location
 l66 -location)
(:init 

        (at brick1 l22);brick1
        (at brick1 l23)
        (at brick1 l24)
        (big brick1)
        (isH brick1)
        
        (at brick2 l11);brick2
        (at brick2 l21)
        (small brick2)
        (isV brick2)
        
        (at brick3 l15);brick3
        (at brick3 l25)
        (small brick3)
        (isV brick3)
        
        (at brick4 l41);brick4
        (at brick4 l42)
        (small brick4)
        (isH brick4)
        
        (at brick5 l33);brick5
        (at brick5 l43)
        (small brick5)
        (isV brick5)
        
        (at brick6 l16);brick6
        (at brick6 l26)
        (at brick6 l36)
        (big brick6)
        (isV brick6)
        
        (at brick7 l34);brick7
        (at brick7 l44)
        (small brick7)
        (isV brick7)
        
        (at brick8 l35);brick8
        (at brick8 l45)
        (small brick8)
        (isV brick8)
        
        (at brick9 l54);brick9
        (at brick9 l64)
        (small brick9)
        (isV brick9)
        
        (at brick10 l55);brick10
        (at brick10 l56)
        (small brick10)
        (isH brick10)
        
        (at brick11 l65);brick11
        (at brick11 l66)
        (small brick11)
        (isH brick11)
    
        
        (at red l31);red
        (at red l32)
        (small red)
        (isH red)
        
        (empty l12)
        (empty l13)
        (empty l14)
        (empty l46)
        (empty l51)
        (empty l52)
        (empty l53)
        (empty l61)
        (empty l62)
        (empty l63)
        
        
       (leftTo l11 l12);leftTo
       (leftTo l12 l13)
       (leftTo l13 l14)
       (leftTo l14 l15)
       (leftTo l15 l16)
       (leftTo l21 l22)
       (leftTo l22 l23)
       (leftTo l23 l24)
       (leftTo l24 l25)
       (leftTo l25 l26)
       (leftTo l31 l32)
       (leftTo l32 l33)
       (leftTo l33 l34)
       (leftTo l34 l35)
       (leftTo l35 l36)
       (leftTo l41 l42)
       (leftTo l42 l43)
       (leftTo l43 l44)
       (leftTo l44 l45)
       (leftTo l45 l46)
       (leftTo l51 l52)
       (leftTo l52 l53)
       (leftTo l53 l54)
       (leftTo l54 l55)
       (leftTo l55 l56)
       (leftTo l61 l62)
       (leftTo l62 l63)
       (leftTo l63 l64)
       (leftTo l64 l65)
       (leftTo l65 l66)
       
       
       (rightTo l12 l11);rightTo
       (rightTo l13 l12)
       (rightTo l14 l13)
       (rightTo l15 l14)
       (rightTo l16 l15)
       (rightTo l22 l21)
       (rightTo l23 l22)
       (rightTo l24 l23)
       (rightTo l25 l24)
       (rightTo l26 l25)
       (rightTo l32 l31)
       (rightTo l33 l32)
       (rightTo l34 l33)
       (rightTo l35 l34)
       (rightTo l36 l35)
       (rightTo l42 l41)
       (rightTo l43 l42)
       (rightTo l44 l43)
       (rightTo l45 l44)
       (rightTo l46 l45)
       (rightTo l52 l51)
       (rightTo l53 l52)
       (rightTo l54 l53)
       (rightTo l55 l54)
       (rightTo l56 l55)
       (rightTo l62 l61)
       (rightTo l63 l62)
       (rightTo l64 l63)
       (rightTo l65 l64)
       (rightTo l66 l65)
       
       
       (upTo l11 l21);upTo
       (upTo l21 l31)
       (upTo l31 l41)
       (upTo l41 l51)
       (upTo l51 l61)
       (upTo l12 l22)
       (upTo l22 l32)
       (upTo l32 l42)
       (upTo l42 l52)
       (upTo l52 l62)
       (upTo l13 l23)
       (upTo l23 l33)
       (upTo l33 l43)
       (upTo l43 l53)
       (upTo l53 l63)
       (upTo l14 l24)
       (upTo l24 l34)
       (upTo l34 l44)
       (upTo l44 l54)
       (upTo l54 l64)
       (upTo l15 l25)
       (upTo l25 l35)
       (upTo l35 l45)
       (upTo l45 l55)
       (upTo l55 l65)
       (upTo l16 l26)
       (upTo l26 l36)
       (upTo l36 l46)
       (upTo l46 l56)
       (upTo l56 l66)
       
       (downTo l21 l11);downTo
       (downTo l31 l21)
       (downTo l41 l31)
       (downTo l51 l41)
       (downTo l61 l51)
       (downTo l22 l12)
       (downTo l32 l22)
       (downTo l42 l32)
       (downTo l52 l42)
       (downTo l62 l52)
       (downTo l23 l13)
       (downTo l33 l23)
       (downTo l43 l33)
       (downTo l53 l43)
       (downTo l63 l53)
       (downTo l24 l14)
       (downTo l34 l24)
       (downTo l44 l34)
       (downTo l54 l44)
       (downTo l64 l54)
       (downTo l25 l15)
       (downTo l35 l25)
       (downTo l45 l35)
       (downTo l55 l45)
       (downTo l65 l55)
       (downTo l26 l16)
       (downTo l36 l26)
       (downTo l46 l36)
       (downTo l56 l46)
       (downTo l66 l56)
       
        )
(:goal (and (at red l35) (at red l36)))

)