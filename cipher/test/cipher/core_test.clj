(ns cipher.core-test
  (:require [midje.sweet :refer :all]
            [cipher.core :as core]))

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (fact "o caractere a é a primeira letra, na posição 0"
             (core/to-int \a) => 0)
       (fact "o caractere b é a segunda letra, na posição 1"
             (core/to-int \b) => 1))

(facts "recebe um numero e retorna caractere correspondente"
       (fact "o numero 0 é a letra a"
             (core/to-char 0) => \a))

(fact (core/shift \z 3) => \c)

(fact (core/caesar-encrypt "apple" 20) => "ujjfy")

(fact (core/caesar-decrypt "ujjfy" 20) => "apple")

(fact (core/get-letters "Hello, friend!") => "hellofriend")

(fact (core/encrypt-text "Hello, friend!" 5) => "mjqqtkwnjsi")

(fact (core/frequency-hashmap) => {\a 7, \b 8, \c 16, \d 10, \e 8, \f 0, \g 16, \h 5, \i 13, \j 8, \k 2, \l 1,
                                   \m 0, \n 2, \o 1, \p 19, \q 3, \r 8, \s 6, \t 17, \u 5, \v 11, \w 4, \x 17,
                                   \y 1, \z 0})

(fact (core/count-letters \a "aadvark") => 3)
(fact (core/count-letters \z "aadvark") => 0)