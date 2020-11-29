(defproject cnuernber/julia-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cnuernber/dtype-next "6.00-beta-8"]
                 [techascent/tech.jna "4.05"]]
  :java-source-paths ["java"]
  ;;sane logging please
  :profiles {:dev {:dependencies [[ch.qos.logback/logback-classic "1.2.3"]]}
             :codox {:dependencies [[codox-theme-rdash "0.1.2"]]
                     :plugins [[lein-codox "0.10.7"]]
                     :codox {:project {:name "libjulia-clj"}
                             :metadata {:doc/format :markdown}
                             :themes [:rdash]
                             :source-paths ["src"]
                             :output-path "docs"
                             :doc-paths ["topics"]
                             :source-uri "https://github.com/cnuernber/libjulia-clj/blob/master/{filepath}#L{line}"
                             :namespaces [libjulia-clj.julia
                                          libjulia-clj.modules.Base
                                          libjulia-clj.modules.Core
                                          libjulia-clj.modules.LinearAlgebra]}}}
  :aliases {"codox" ["with-profile" "codox,dev" "codox"]})
