(ns hackandprotect.utils)

(defn map-in-str [f s from len]
  (let [before (subs s 0 from)
        after (subs s (+ from len))
        being-replaced (subs s from (+ from len))
        replaced (apply str (map f being-replaced))]
    (str before replaced after)))
