(ns cipher.core)

(defn to-int
  "recebe uma letra minúscola e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  [number]
  (let [int-a (int \a)]
    (-> int-a
        (+ number)
        char)))

(defn shift
  [letter n]
  (-> letter
      to-int
      (+ n)
      (mod 26)
      to-char))

(defn caesar-encrypt
  "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
  [w k]
  (apply str (mapv #(shift % k) w)))

(defn caesar-decrypt
  "retornando a encriptação da palavra"
  [word key]
  (apply str (mapv #(shift % (- key)) word)))

(defn get-letters
  "recebendo uma palavra e retornando apenas letras e convertendo para minusculas"
  [text]
  (->> (filter #(Character/isLetter %) text)
       (apply str)
       clojure.string/lower-case))

(defn encrypt-text
  "encriptando apenas letras com a cifra de César"
  [text key]
  (-> (get-letters text)
      (caesar-encrypt key)))

(def alphabet (map to-char (range 26)))

(def encr1 "radyjgtxhpsncpbxrvtctgpaejgedhtegdvgpbbxcvapcvjpvtrdbqxcxcv
iwtpeegdprwpqxaxinpcsxcitgprixktstktadebtciduphrgxeixcvapcvjp
vtlxiwpctuuxrxtcipcsgdqjhixcugphigjrijgtudgbjaixiwgtpstsegdvg
pbbxcvo")

(defn frequency-hashmap
  ""
  []
  (zipmap alphabet(map #(count-letters % encr1) alphabet)))

(defn count-letters
  "contando a quantidade de caracteres na palavra"
  [letter text]
  (count (filter #(= letter %) text)))