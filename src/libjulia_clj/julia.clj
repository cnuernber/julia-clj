(ns libjulia-clj.julia
  (:require [libjulia-clj.impl.base :as base]
            [tech.v3.datatype.export-symbols :refer [export-symbols]]))




(export-symbols libjulia-clj.impl.base
                initialize!)


(defn eval-string
  [str-data]
  (-> (base/jl_eval_string str-data)
      (base/jl->clj)))