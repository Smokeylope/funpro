(defproject v5s1 "0.1.0-SNAPSHOT"
  :description "An example of using Midje for unit testing."
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot v5s1.core
  :target-path "target/%s"
  :profiles {
  :dev {
  	:dependencies [[midje "1.7.0"]]
  	:plugins [[lein-midje "2.0.0-SNAPSHOT"]]}
  :uberjar {
  	:aot :all}})
