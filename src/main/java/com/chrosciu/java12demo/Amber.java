package com.chrosciu.java12demo;

import javax.validation.constraints.NotNull;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Amber {

    class Jep323VarInLambdaParameters {
        BiFunction<Integer, Integer, Boolean> fooNewStyle = (@NotNull var x, @NotNull var y) -> x > y;
    }

    class Jep325SwitchExpressions {
        void newSwitchExpressionWithLambdas(String s) {
            switch (s) {
                case "Foo" -> System.out.println("good");
                case "Bar" -> System.out.println("bad");
            }
        }

        String newSwitchExpressionWithReturn(String s) {
            return switch (s) {
                case "Foo" -> "bad";
                case "Bar" -> "good";
                default -> "wtf ?";
            };
        }

        String newSwitchExpressionWithBreak(String s) {
            return switch (s) {
                case "Foo": break "Bad";
                case "Bar": break "Good";
                default: {
                    break s.toLowerCase();
                }
            };
        }
    }

    class Jep302LambdaLeftovers {
        // denote unused parameter
        // BiFunction<Integer, String, String> biss = (i, _) -> String.valueOf(i);

        private void shadowing() {
            int x = 0;
            // can declare lambda parameter named x, shadowing the local variable x
            //Function<Integer, String> fis = (x) -> String.valueOf(x);
        }

        void foo(Predicate<String> ps) {}
        void foo(Function<String, String> fss) {}

        class Fuu {
            boolean  bar(String s) { return false; }
            boolean bar(Integer i) { return false; }
        }

        Fuu fuu = new Fuu();

        void problemsWithLambdaInference() {
            // error due to ambiguity, although Predicate should have been inferred
            // foo(s -> false);

            // error due to ambiguity, although boolean bar(String s) should have been selected
            // foo(fuu::bar);
        }
    }

    class Jep305PatternMatching {
        String oldSchoolInstanceOfAndCast(Object o) {
            String value;
            if (o instanceof Integer) {
                value = String.valueOf((Integer)o);
            } else if (o instanceof Float) {
                value = String.valueOf((Float)o);
            } else  {
                value = o.toString();
            }
            return value;
        }

        String newProposalOfMatching(Object o) {
            String value = null;
//            if (o matches Integer i) {
//                value = String.valueOf(i);
//            } else if (o matches Float f) {
//                value = String.valueOf(f);
//            } else  {
//                value = o.toString();
//            }
            return value;
        }
    }

    class Jep325SwitchExpressionsWithPatternMatching {
        String newSwitchExpression(Object o) {
            String value = null;
//            switch(o) {
//                case Integer i: value = String.valueOf(i); break;
//                case Float f: value = String.valueOf(f); break;
//                default: value = o.toString();
//            }
            return value;
        }

        String newSwitchExpressionWithLambdas(Object o) {
//            return switch(o) {
//                case Integer i -> String.valueOf(i);
//                case Float f -> String.valueOf(f);
//                default -> o.toString();
//            }
            return null;
        }
    }



    class Jep326RawStrings {
        String oldHtml =
                "<html>\n" +
                "    <body>\n" +
                "		    <p>Hello World.</p>\n" +
                "    </body>\n" +
                "</html>\n";
//        String newHtml =
//                        `<html>
//                            <body>
//                                <p>Hello World.</p>
//                            </body>
//                        </html>`;
        String oldPattern = "\\w\\w\\w\\w";
//        String newPattern = `\w\w\w\w`;
    }

}
